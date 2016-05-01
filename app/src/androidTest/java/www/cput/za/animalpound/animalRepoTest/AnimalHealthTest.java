package www.cput.za.animalpound.animalRepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import www.cput.za.animalpound.domain.AnimalHealth;
import www.cput.za.animalpound.repository.animal.AnimalHealthRepository;
import www.cput.za.animalpound.repository.animal.Impl.AnimalHealthRepositoryImpl;

/**
 * Created by Game330 on 2016-04-29.
 */
public class AnimalHealthTest extends AndroidTestCase {
    private static final String TAG="SETTINGS TEST";
    private Long id;
    // private Context getContext;

    public void testCreateReadUpdateDelete() throws Exception {
        AnimalHealthRepository repo = new AnimalHealthRepositoryImpl(this.getContext());
        // CREATE

        AnimalHealth createEntity = new AnimalHealth.Builder()
                .id(Long.parseLong("234324"))
                .condition("Well")
                .Description("N/A")
                .build();
        AnimalHealth insertedEntity = repo.save(createEntity);
        id=insertedEntity.getHealthID();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<AnimalHealth> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        AnimalHealth entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        AnimalHealth updateEntity = new AnimalHealth.Builder()
                .copy(entity)
                .id(Long.parseLong("234324"))
                .build();
        repo.update(updateEntity);
        AnimalHealth newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","234324",newEntity.getHealthID());

        // DELETE ENTITY
        repo.delete(updateEntity);
        AnimalHealth deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
