//package com.setec.online_survey.mapper;
//
//import co.istad.lms.features.classes.dto.*;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring", uses = {StudentMapper.class, InstructorMapper.class})
//public interface ClassMapper {
//
//
//    //    @Mapping(target = "instructor",ignore = true)
//    @Mapping(target = "studyProgram", ignore = true)
//    @Mapping(target = "shift", ignore = true)
//    @Mapping(target = "generation", ignore = true)
//    @Mapping(target = "students", ignore = true)
//    @Mapping(target = "classStart",ignore = true)
//    @Mapping(target = "classEnd",ignore = true)
//    Class fromClassRequest(ClassRequest classRequest);
//
//
//    ClassDetailResponse toClassDetailResponse(Class classes);
//
//    ClassResponse toClassResponse(Class classes);
//
//    //    @Mapping(target = "instructor",ignore = true)
//    @Mapping(target = "studyProgram", ignore = true)
//    @Mapping(target = "shift", ignore = true)
//    @Mapping(target = "generation", ignore = true)
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateClassFromRequest(@MappingTarget Class classes, ClassUpdateRequest classUpdateRequest);
//
//
//    ClassAssessmentResponse toClassAssessmentResponse(Class oneClass);
//}
