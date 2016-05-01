package www.cput.za.animalpound.animalRepoTest;

import www.cput.za.animalpound.domain.Animal;
import www.cput.za.animalpound.repository.animal.AnimalRepository;
import www.cput.za.animalpound.repository.animal.Impl.AnimalRepositoryImpl;

import android.test.AndroidTestCase;
import junit.framework.Assert;


import java.util.Set;


/**
 * Created by Game330 on 2016-04-29.
 */

public class AnimalTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;
   // private Context getContext;

    public void testCreateReadUpdateDelete() throws Exception {
        AnimalRepository repo = new AnimalRepositoryImpl(this.getContext());
        // CREATE

         Animal createEntity = new Animal.Builder()
                .animalId(Long.parseLong("234324"))
                .breed("Dog")
                .weight(324)
                .build();
        Animal insertedEntity = repo.save(createEntity);
        id=insertedEntity.getAnimalId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Animal> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Animal entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Animal updateEntity = new Animal.Builder()
                .copy(entity)
                .animalId(Long.parseLong("234324"))
                .build();
        repo.update(updateEntity);
        Animal newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","234324",newEntity.getAnimalId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Animal deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
