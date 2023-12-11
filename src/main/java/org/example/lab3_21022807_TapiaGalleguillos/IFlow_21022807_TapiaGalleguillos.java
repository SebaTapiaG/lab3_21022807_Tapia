package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.List;

public interface IFlow_21022807_TapiaGalleguillos {
    public int getId();

    public List<Option_21022807_TapiaGalleguillos> getOption();

    public void flowAddOption(Option_21022807_TapiaGalleguillos op);

    public boolean mismoId(int id);

    public List<String> verOptions();

    public String verFlow();
}
