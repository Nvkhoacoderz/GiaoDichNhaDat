package com.teamforone.giaodichnhadat.persistence;

import com.teamforone.giaodichnhadat.business.GiaoDichEditDTO;

import java.sql.SQLException;
import java.util.List;

public interface GiaoDichDAOGateway {
    GiaoDichDTO editGiaoDich(GiaoDichDTO giaoDichDTO) throws SQLException;
    GiaoDichDTO timGiaoDich(String maGiaoDich) throws SQLException;
    List<GiaoDichDTO> layTatCaGiaoDich() throws SQLException;
    GiaoDichDTO getGiaoDichByMa(String maGiaoDich) throws SQLException;
}
