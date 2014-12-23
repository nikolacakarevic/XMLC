package at.xmlc.dao;

import at.xmlc.model.xml.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class AbstractDao<E extends AbstractEntity, ID extends Serializable>
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName="XMLC")
    protected EntityManager en;

    public EntityManager getEntityManager() {
        return en;
    }

    public void create(E entity) {
        en.persist(entity);
    }

    public void update(E entity) {
        en.merge(entity);
    }

    public E read(Class<E> type, ID id) {
        return en.find(type, id);
    }

    public E findById(Class<E> type, ID id) {
        E result = en.find(type, id);
        if (result == null) throw new IllegalArgumentException("Cant find entity " + type.getSimpleName() + " by id: " + id);
        return result;
    }


    public E getReference(Class<E> type, ID id) {
        return en.getReference(type, id);
    }

    public void delete(Class<E> type, ID id) {
        E entity = en.find(type, id);
        en.remove(entity);
    }

    public void flush() {
        en.flush();
    }

    public List<E> selectAll(Class<E> type) {
        CriteriaBuilder cb = en.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(type);

        Root<E> rootEntry = cq.from(type);
        CriteriaQuery<E> all = cq.select(rootEntry);
        TypedQuery<E> allQuery = en.createQuery(all);

        return allQuery.getResultList();
    }


}
