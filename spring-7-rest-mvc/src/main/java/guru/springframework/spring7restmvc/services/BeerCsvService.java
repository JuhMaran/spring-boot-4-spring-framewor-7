package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.BeerCSVRecord;

import java.io.File;
import java.util.List;

/**
 * spring-7-rest-mvc
 *
 * @author Juliane Maran
 * @since 24/02/2026
 */
public interface BeerCsvService {

  List<BeerCSVRecord> convertCSV(File csvFile);

}
