package org.entity;

public class InputDataEntity {
    private Integer id;
    private String name;
    private Boolean isMobile;
    private Integer score;

    public InputDataEntity(){}

    public InputDataEntity(Integer id, String name, Boolean isMobile, Integer score) {
        this.id = id;
        this.name = name;
        this.isMobile = isMobile;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMobile() {
        return isMobile;
    }

    public void setMobile(Boolean mobile) {
        isMobile = mobile;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputDataEntity that = (InputDataEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (isMobile != null ? !isMobile.equals(that.isMobile) : that.isMobile != null) return false;
        return score != null ? score.equals(that.score) : that.score == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isMobile != null ? isMobile.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
