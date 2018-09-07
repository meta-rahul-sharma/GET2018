package com.metacube.training.models;

public class SkillsMaster {
	private int skillId;
	private String skillName;
	SkillsMaster(int skillId, String skillName) {
	    this.skillId = skillId;
	    this.skillName = skillName;
	}
    public int getSkillId() {
        return skillId;
    }
    public String getSkillName() {
        return skillName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
