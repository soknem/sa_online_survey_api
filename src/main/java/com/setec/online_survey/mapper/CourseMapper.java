//package com.setec.online_survey.mapper;
//
//import co.istad.lms.domain.Course;
//import co.istad.lms.domain.Score;
//import co.istad.lms.features.course.dto.*;
//import co.istad.lms.util.MediaUtil;
//import org.mapstruct.*;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = "spring", uses = {StudentMapper.class, InstructorMapper.class, SubjectMapper.class, ClassMapper.class , ScoreMapper.class})
//public interface CourseMapper {
//
//
//    CourseAttendanceResponse toCourseAttendanceResponse(Course course);
//
//    @Mapping(target = "subject", ignore = true)
//    @Mapping(target = "instructor", ignore = true)
//    @Mapping(target = "oneClass", ignore = true)
//    @Mapping(target = "courseStart", ignore = true)
//    Course fromCourseRequest(CourseRequest courseRequest);
//
//    CourseDetailResponse toCourseDetailResponse(Course course);
//
//    CourseSemesterScoreResponse toCourseSemesterScoreResponse(Course course);
//
//    @Mapping(source = "subject.title", target = "title")
//    @Mapping(source = "subject.credit", target = "credit")
//    @Mapping(source = "scores", target = "score", qualifiedByName = "getTotalScore")
//    @Mapping(source = "scores", target = "grade", qualifiedByName = "getGrade")
//    CourseResponse toCourseResponse(Course course);
//
//    @Named("getTotalScore")
//    default Double getTotalScore(Set<Score> scores) {
//        return scores != null && !scores.isEmpty() ? scores.iterator().next().getTotal() : null;
//    }
//
//    @Named("getGrade")
//    default String getGrade(Set<Score> scores) {
//        return scores != null && !scores.isEmpty() ? scores.iterator().next().getGrade() : null;
//    }
//
//    CourseClassResponse toCourseClassResponse(Course course);
//
//    @Mapping(target = "subject", ignore = true)
//    @Mapping(target = "instructor", ignore = true)
//    @Mapping(target = "oneClass", ignore = true)
//    @Mapping(target = "courseStart", ignore = true)
//    @Mapping(target = "courseEnd", ignore = true)
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateCourseFromRequest(@MappingTarget Course course, CourseUpdateRequest courseUpdateRequest);
//
//
//    @Named("toCourseStudentResponse")
//    @Mapping(source = "instructor.user.profileImage", target = "instructorProfileImage", qualifiedByName = "getLogoUrlCourse")
//    @Mapping(source = "instructor.user.nameEn", target = "instructorName")
//    @Mapping(source = "yearOfStudy.year", target = "year")
//    @Mapping(source = "yearOfStudy.semester", target = "semester")
//    @Mapping(source = "subject.credit", target = "credit")
//    @Mapping(source = "subject.logo", target = "logo" , qualifiedByName = "getLogoUrlCourse")
//    @Mapping(source = "subject.description", target = "description")
//    CourseWithUsersResponse toCourseStudentResponse(Course course);
//
//
//
////    @Named("toCourseWithUsersResponseSet")
//    @Mappings({
//            @Mapping(target = "status" , source = "status"),
//            @Mapping(source = "subject.credit", target = "credit"),
//            @Mapping(source = "subject.logo", target = "logo" , qualifiedByName = "getLogoUrlCourse"),
//            @Mapping(source = "subject.description", target = "description"),
//            @Mapping(source = "instructor.user.nameEn", target = "instructorName"),
//            @Mapping(source = "instructor.user.profileImage", target = "instructorProfileImage" , qualifiedByName = "getLogoUrlCourse"),
//            @Mapping(source = "yearOfStudy.year", target = "year"),
//            @Mapping(source = "yearOfStudy.semester", target = "semester")
//    })
//    CourseWithUsersResponse toCourseWithUsersResponse(Course course);
//
//
//
//
//    @Named("toUseCourseResponse")
//    @Mapping(source = "subject.title", target = "title")
//    @Mapping(source = "subject.credit", target = "credit")
//    @Mapping(source = "scores", target = "score", qualifiedByName = "mapScoresToTotal")
//    @Mapping(source = "scores", target = "grade", qualifiedByName = "mapScoresToAverageGrade")
//    CourseResponse toUseCourseResponse(Course course);
//
//    @Named("mapScoresToTotal")
//    default Double mapScoresToTotal(Set<Score> scores) {
//        return scores.stream()
//                .mapToDouble(Score::getTotal)
//                .sum();
//    }
//
//    @Named("mapScoresToAverageGrade")
//    default String mapScoresToAverageGrade(Set<Score> scores) {
//        return scores.stream()
//                .map(Score::getGrade)
//                .collect(Collectors.joining(", "));
//    }
//
//
//    @Named("getLogoUrlCourse")
//    default String getLogoUrlCourse(String logo) {
//
//        if (logo != null && !logo.trim().isEmpty()) {
//            return MediaUtil.getUrl(logo);
//        } else {
//            return null;
//        }
//    }
//
//
//
//}
