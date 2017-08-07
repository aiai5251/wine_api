package com.chimu.wine.dao;

import com.chimu.wine.bean.TeamBean;

import java.util.List;

public interface TeamDao {
    void addTeam(TeamBean teamBean);
    TeamBean getTeamFidByUid(Integer uid);

    List<TeamBean> getTeamUidByFid(Integer fri_id);
}
