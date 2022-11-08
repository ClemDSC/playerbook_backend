package com.playerbook.demo.userGameInfo;

public class UserGameInfo {

    private Long id;
    private String userPseudo;
    private String guild;
    private Long level;
    private String rank;
    private String difficulty;
    private String serverName;

    public UserGameInfo(Long id, String userPseudo, String guild, Long level, String rank, String difficulty, String serverName, Long user_id, Long game_id) {
        this.id = id;
        this.userPseudo = userPseudo;
        this.guild = guild;
        this.level = level;
        this.rank = rank;
        this.difficulty = difficulty;
        this.serverName = serverName;
    }

    public UserGameInfo() {
    }

    public Long getId() {
        return id;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public String getGuild() {
        return guild;
    }

    public Long getLevel() {
        return level;
    }

    public String getRank() {
        return rank;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getServerName() {
        return serverName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

}
