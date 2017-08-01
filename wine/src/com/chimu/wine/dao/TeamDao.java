package com.chimu.wine.dao;

import com.chimu.wine.bean.TeamBean;
import org.apache.ibatis.annotations.Param;

public interface TeamDao {
    void addTeam(TeamBean teamBean);
    TeamBean getTeamByUidWithFid(@Param("uid")Integer uid, @Param("fri_id")Integer fri_id);
}
