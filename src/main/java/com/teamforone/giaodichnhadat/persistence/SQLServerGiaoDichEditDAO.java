package com.teamforone.giaodichnhadat.persistence;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SQLServerGiaoDichEditDAO implements GiaoDichDAOGateway {
    private Connection conn;

    public SQLServerGiaoDichEditDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String username = "sa";
        String password = "Nguyenvukhoa544@";
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=TeamForOne;encrypt=true;trustServerCertificate=true";
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected!!!");
    }

    @Override
    public GiaoDichDTO editGiaoDich(GiaoDichDTO dto) throws SQLException {
        String sql = """
        UPDATE GiaoDich
        SET NgayGiaoDich = ?, 
            LoaiGiaoDich = ?,
            DiaChi = ?, 
            DienTich = ?,
            DonGia = ?, 
            LoaiDat = ?, 
            LoaiNha = ?
        WHERE MaGiaoDich = ?
    """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Ngày giao dịch
            java.sql.Date sqlDate = dto.ngayGiaoDich != null ? java.sql.Date.valueOf(dto.ngayGiaoDich) : null;
            stmt.setDate(1, sqlDate);

            stmt.setDouble(5, dto.donGia);
            stmt.setString(2, dto.loaiGiaoDich);
            stmt.setDouble(4, dto.dienTich);
            stmt.setString(3, dto.diaChi);

            // Loại giao dịch xử lý cột loại đất / loại nhà
            if ("dat".equalsIgnoreCase(dto.loaiGiaoDich)) {
                stmt.setString(6, dto.loaiDat);
                stmt.setNull(7, Types.NVARCHAR); // LoaiNha null
            } else if ("nha".equalsIgnoreCase(dto.loaiGiaoDich)) {
                stmt.setNull(6, Types.CHAR); // LoaiDat null

                // Sửa đoạn này để map "Cao cấp"/"Thường" sang "cao_cap"/"thuong"
                String dbLoaiNha = null;
                if ("Cao cấp".equalsIgnoreCase(dto.loaiNha)) dbLoaiNha = "cao_cap";
                else if ("Thường".equalsIgnoreCase(dto.loaiNha)) dbLoaiNha = "thuong";
                else dbLoaiNha = dto.loaiNha; // fallback nếu đã chuẩn

                stmt.setString(7, dbLoaiNha);
            } else {
                throw new SQLException("Loại giao dịch không hợp lệ: " + dto.loaiGiaoDich);
            }

            stmt.setString(8, dto.maGiaoDich);

            // Quan trọng: dùng executeUpdate thay vì executeQuery
            stmt.executeUpdate();
        }

        // Trả lại bản ghi đã update
        return getGiaoDichByMa(dto.maGiaoDich);
    }

    @Override
    public GiaoDichDTO getGiaoDichByMa(String maGiaoDich) throws SQLException {
        GiaoDichDTO giaoDich = null;
        String sql = "SELECT * FROM GiaoDich WHERE MaGiaoDich = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maGiaoDich);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    giaoDich = new GiaoDichDTO();
                    giaoDich.maGiaoDich = rs.getString("MaGiaoDich");
                    giaoDich.ngayGiaoDich = rs.getDate("NgayGiaoDich").toLocalDate();
                    giaoDich.loaiGiaoDich = rs.getString("LoaiGiaoDich");
                    giaoDich.diaChi = rs.getString("DiaChi");
                    giaoDich.dienTich = rs.getDouble("DienTich");
                    giaoDich.donGia = rs.getDouble("DonGia");
                    giaoDich.loaiDat = rs.getString("LoaiDat");
                    giaoDich.loaiNha = rs.getString("LoaiNha");
                }
            }
        }
        return giaoDich;
    }

    @Override
    public GiaoDichDTO timGiaoDich(String maGiaoDich) throws SQLException {
        GiaoDichDTO giaoDich = null;
        PreparedStatement stmt;

        String query = "select * from GiaoDich where MaGiaoDich = ?";

        ResultSet rs = null;

        stmt = conn.prepareStatement(query);
        stmt.setString(1, maGiaoDich);
        rs = stmt.executeQuery();
        try {
            while(rs.next()) {
                giaoDich = new GiaoDichDTO();
                giaoDich.maGiaoDich = rs.getString("MaGiaoDich");
                giaoDich.ngayGiaoDich = rs.getDate("NgayGiaoDich").toLocalDate();
                giaoDich.loaiGiaoDich = rs.getString("LoaiGiaoDich");
                giaoDich.diaChi = rs.getString("DiaChi");
                giaoDich.dienTich = rs.getDouble("DienTich");
                giaoDich.donGia = rs.getDouble("DonGia");
                giaoDich.loaiDat = rs.getString("LoaiDat");
                giaoDich.loaiNha = rs.getString("LoaiNha");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return giaoDich;
    }

    //	nếu m muốn lấy cái này thì phải nối thông qua business vào
    public List<GiaoDichDTO> layTatCaGiaoDich() throws SQLException {
        List<GiaoDichDTO> list = new ArrayList<>();
        String query = "SELECT * FROM GiaoDich";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                GiaoDichDTO giaoDich = new GiaoDichDTO();
                giaoDich.maGiaoDich = rs.getString("MaGiaoDich");
                giaoDich.ngayGiaoDich = rs.getDate("NgayGiaoDich").toLocalDate();
                giaoDich.loaiGiaoDich = rs.getString("LoaiGiaoDich");
                giaoDich.diaChi = rs.getString("DiaChi");
                giaoDich.dienTich = rs.getDouble("DienTich");
                giaoDich.donGia = rs.getDouble("DonGia");
                giaoDich.loaiDat = rs.getString("LoaiDat");
                giaoDich.loaiNha = rs.getString("LoaiNha");


                list.add(giaoDich);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}
