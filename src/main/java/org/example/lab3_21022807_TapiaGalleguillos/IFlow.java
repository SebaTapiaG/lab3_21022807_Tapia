package org.example.lab3_21022807_TapiaGalleguillos;

import java.util.List;

public interface IFlow {
    public int getId();

    public List<Option> getOption();

    public void flowAddOption(Option op);

    public boolean mismoId(int id);

    public List<String> verOptions();

    public String verFlow();
}
