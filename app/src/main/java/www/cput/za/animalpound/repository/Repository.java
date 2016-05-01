package www.cput.za.animalpound.repository;

import java.util.Set;

/**
 * Created by Game330 on 2016-04-25.
 */
public interface Repository <E, ID>  {


    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();

}
