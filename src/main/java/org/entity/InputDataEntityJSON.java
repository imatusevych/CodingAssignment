package org.entity;

/**
 * Reason usage:
 * - input data format for diff type is not the same
 * - use for jakson mapping
 */
public class InputDataEntityJSON {
    private Integer site_id;
    private String name;
    private Boolean mobile;
    private Integer score;

    public InputDataEntityJSON(Integer site_id, String name, Boolean mobile, Integer score) {
        this.site_id = site_id;
        this.name = name;
        this.mobile = mobile;
        this.score = score;
    }

    public InputDataEntityJSON() {
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
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

        InputDataEntityJSON that = (InputDataEntityJSON) o;

        if (site_id != null ? !site_id.equals(that.site_id) : that.site_id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        return score != null ? score.equals(that.score) : that.score == null;

    }

    @Override
    public int hashCode() {
        int result = site_id != null ? site_id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
