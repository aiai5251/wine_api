package com.chimu.wine.service;

import com.chimu.wine.bean.TeamBean;
import com.chimu.wine.dao.TeamDao;
import com.chimu.wine.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private TeamDao teamDao;
    private UserDao userDao;

    public TeamService(TeamDao teamDao, UserDao userDao) {
        this.teamDao = teamDao;
        this.userDao = userDao;
    }

    public void addTeam(TeamBean teamBean) {
        teamDao.addTeam(teamBean);
    }

    public TeamBean getTeamFidByUid(Integer uid) {
        return teamDao.getTeamFidByUid(uid);
    }

    public List<TeamBean> getTeamUidByFid(Integer fri_id) {
        List<TeamBean> teamBeans = new ArrayList<>();
        for (TeamBean teamBean : teamDao.getTeamUidByFid(fri_id)) {
            teamBean.setUserBean(userDao.getUserById(teamBean.getUid()));
            teamBeans.add(teamBean);
        }
        return teamBeans;
    }
}
