package org.example.lab3_21022807_Tapia;

import java.util.List;

public interface IFlow {
    public int getId();

    public String getNameMsg();

    public List<Option> getOption();

    public void setOption(List<Option> option);

    public void flowAddOption(Option op);

    public boolean mismoId(int id);

    List<String> verOptions(List<Option> options);

    public String verFlow();
}
