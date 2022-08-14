package edu.aluismarte.diplomado.week6;

import com.github.javafaker.Faker;
import edu.aluismarte.diplomado.model.week3.FrequencyType;
import lombok.ToString;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aluis on 5/2/2022.
 */
class HomeWorkTest {

    private final HomeWork homeWork = new HomeWork();


    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.HomeWorkTest#provideRandomNames")
    void formDataFullNameTest(String name){
        assertEquals("", homeWork.formValidation(false, false, name, false, ""));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/FIXED.csv")
    void formDataLoanTypeFixed(int loan){
        assertEquals(loan, homeWork.formValidation(true, false, loan, true, null));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SAN.csv")
    void formDataLoanTypeSan(int loan){
        assertEquals(loan, homeWork.formValidation(true, false, loan, true, null));
    }

    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.HomeWorkTest#provideRandomCapital")
    void formDataCapital(double cap){
        assertEquals(cap, homeWork.formValidation(true, false, cap, true, 0));
    }

    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.HomeWorkTest#provideRandomFrequencyType")
    void formDataFrequencyType(FrequencyType frequencyType){
        assertEquals(frequencyType, homeWork.formValidation(true, false, frequencyType, true, FrequencyType.MONTHLY));
    }

    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.HomeWorkTest#provideRandomQuotes")
    void formDataQuotes(int cuota){
        assertEquals(cuota, homeWork.formValidation(true, true, cuota, 12, 1));
    }

    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.HomeWorkTest#provideRandomInterest")
    void formDataInterest(String Interes) {
        assertEquals(8.5, homeWork.formValidation(false, true, Interes, 8.5, 0));
    }

    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.HomeWorkTest#provideRandomDates")
    void formDataDates(String localDate) {
        assertEquals(localDate, homeWork.formValidation(true, true, localDate, false, null));
    }

    @ParameterizedTest
    @MethodSource("edu.aluismarte.diplomado.week6.HomeWorkTest#provideRandomPreDataNull")
    void formDataPreDataNull() {
        assertEquals(0, homeWork.formValidation(true, false, null, null, 0));
    }

    //Provider Methods

    static Stream<Arguments> provideRandomNames() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(
                faker.name().fullName()));
    }

    static Stream<Arguments> provideRandomCapital() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(
                faker.number().randomDouble(5,10000, 90000)));
    }

    static Stream<Arguments> provideRandomFrequencyType() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(
                faker.expression("MONTHLY")));
    }

    static Stream<Arguments> provideRandomQuotes() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(
                faker.number().numberBetween(12,12)));
    }

    static Stream<Arguments> provideRandomInterest() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(faker.expression("8.5")));
    }

    static Stream<Arguments> provideRandomDates() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(faker.expression(LocalDate.now().toString())));
    }

    static Stream<Arguments> provideRandomPreDataNull() {
        Faker faker = new Faker();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(faker.equals(null)));
    }

    /**static Stream<Arguments> provideRandomLoan() {
     Faker faker = new Faker();
     return IntStream.range(0, 20).mapToObj(value -> Arguments.of(
     faker.number().randomDigitNotZero()));
     }*/

}