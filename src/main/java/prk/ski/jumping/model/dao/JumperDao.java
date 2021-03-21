package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.Jumper;

import java.util.List;

public interface JumperDao {
    public void create(Jumper jumper);

    public Jumper getById(long id);

    public List<Jumper> getAll();

    public void update(Jumper jumper, long id);

    public void delete(Jumper jumper, long id);
}
