package ext.domain.audiomatch.models;

public class Podcast extends  AudioMatch {
    private String presenter;
    private String description;

    @Override
    public int getClassification() {
        if (getReproductions() > 300) {
            return 9;
        } else {
            return 3;
        }
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
