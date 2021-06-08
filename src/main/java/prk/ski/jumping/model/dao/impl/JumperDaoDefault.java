package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.model.dao.JumperDao;
import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.memory.JumperDB;

import java.util.List;
import java.util.Optional;

/**
 * @author RadosławParol
 */

public class JumperDaoDefault implements JumperDao {
    private JumperDB jumperDB;

    public JumperDaoDefault() {
        jumperDB = new JumperDB();
    }

    @Override
    public void create(Jumper jumper) { jumperDB.create(jumper); }
    @Override
    public Optional<Jumper> getById(long id) { return jumperDB.getById(id); }
    @Override
    public List<Jumper> getAll() { return jumperDB.getAll();}
    @Override
    public void update(Jumper jumper, long id) { jumperDB.update(jumper, id);}
    @Override
    public void delete(Jumper jumper, long id) { jumperDB.delete(jumper, id);}

}
