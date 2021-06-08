package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.Jumper;

import java.util.List;
import java.util.Optional;

/**
 * @author RadosławParol
 */

public interface JumperDao {
    void create(Jumper jumper);
    Optional<Jumper> getById(long id);
    List<Jumper> getAll();
    void update(Jumper jumper, long id);
    void delete(Jumper jumper, long id);
}
