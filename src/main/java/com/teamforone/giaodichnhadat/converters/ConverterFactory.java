package com.teamforone.giaodichnhadat.converters;

import com.teamforone.giaodichnhadat.converters.implementations.*;
import com.teamforone.giaodichnhadat.converters.interfaces.*;

/**
 * Factory class for creating converter instances
 * Following Dependency Inversion Principle - provides concrete implementations for interfaces
 * This class enables easy dependency injection and maintains consistency across the application
 */
public class ConverterFactory {
    
    // Singleton instances for better performance
    private static final GiaoDichToEditDTOConverter giaoDichToEditDTOConverter = 
        new GiaoDichToEditDTOConverterImpl();
    
    private static final GiaoDichToViewFindDTOConverter giaoDichToViewFindDTOConverter = 
        new GiaoDichToViewFindDTOConverterImpl();
    
    private static final GiaoDichDTOToBusinessConverter giaoDichDTOToBusinessConverter = 
        new GiaoDichDTOToBusinessConverterImpl();
    
    private static final EditDTOToGiaoDichDTOConverter editDTOToGiaoDichDTOConverter = 
        new EditDTOToGiaoDichDTOConverterImpl();
    
    private static final ViewFindDTOToViewItemConverter viewFindDTOToViewItemConverter = 
        new ViewFindDTOToViewItemConverterImpl();
    
    private static final ParentTypeDTOConverter parentTypeDTOConverter = 
        new ParentTypeDTOConverterImpl();
    
    private static final ChildrenTypeDTOConverter childrenTypeDTOConverter = 
        new ChildrenTypeDTOConverterImpl();
    
    /**
     * Returns the GiaoDichToEditDTOConverter instance
     * @return GiaoDichToEditDTOConverter implementation
     */
    public static GiaoDichToEditDTOConverter getGiaoDichToEditDTOConverter() {
        return giaoDichToEditDTOConverter;
    }
    
    /**
     * Returns the GiaoDichToViewFindDTOConverter instance
     * @return GiaoDichToViewFindDTOConverter implementation
     */
    public static GiaoDichToViewFindDTOConverter getGiaoDichToViewFindDTOConverter() {
        return giaoDichToViewFindDTOConverter;
    }
    
    /**
     * Returns the GiaoDichDTOToBusinessConverter instance
     * @return GiaoDichDTOToBusinessConverter implementation
     */
    public static GiaoDichDTOToBusinessConverter getGiaoDichDTOToBusinessConverter() {
        return giaoDichDTOToBusinessConverter;
    }
    
    /**
     * Returns the EditDTOToGiaoDichDTOConverter instance
     * @return EditDTOToGiaoDichDTOConverter implementation
     */
    public static EditDTOToGiaoDichDTOConverter getEditDTOToGiaoDichDTOConverter() {
        return editDTOToGiaoDichDTOConverter;
    }
    
    /**
     * Returns the ViewFindDTOToViewItemConverter instance
     * @return ViewFindDTOToViewItemConverter implementation
     */
    public static ViewFindDTOToViewItemConverter getViewFindDTOToViewItemConverter() {
        return viewFindDTOToViewItemConverter;
    }
    
    /**
     * Returns the ParentTypeDTOConverter instance
     * @return ParentTypeDTOConverter implementation
     */
    public static ParentTypeDTOConverter getParentTypeDTOConverter() {
        return parentTypeDTOConverter;
    }
    
    /**
     * Returns the ChildrenTypeDTOConverter instance
     * @return ChildrenTypeDTOConverter implementation
     */
    public static ChildrenTypeDTOConverter getChildrenTypeDTOConverter() {
        return childrenTypeDTOConverter;
    }
}