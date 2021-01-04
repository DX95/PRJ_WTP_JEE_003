package service;

import domain.Pagebean;

public interface SearchService {
    Pagebean SearchPagebean(String type, int row, int currentpage);
}
