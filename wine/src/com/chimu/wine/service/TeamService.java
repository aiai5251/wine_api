package com.chimu.wine.service;

import com.chimu.wine.bean.TeamBean;
import com.chimu.wine.bean.UserBean;
import com.chimu.wine.dao.TeamDao;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private TeamDao teamDao;

    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void addTeam(TeamBean teamBean) {
        teamDao.addTeam(teamBean);
    }

    public TeamBean getTeamByUidWithFid(Integer uid, Integer fri_id) {
        TeamBean teamBean = teamDao.getTeamByUidWithFid(uid, fri_id);
        if (teamBean == null) {
            teamBean = teamDao.getTeamByUidWithFid(fri_id, uid);
        }
        return teamBean;
    }

}
