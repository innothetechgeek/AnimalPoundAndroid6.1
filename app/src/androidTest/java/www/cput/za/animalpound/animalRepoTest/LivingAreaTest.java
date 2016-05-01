package www.cput.za.animalpound.animalRepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import www.cput.za.animalpound.domain.LivingArea;
import www.cput.za.animalpound.repository.animal.Impl.LivingAreaRepositoryImpl;
import www.cput.za.animalpound.repository.animal.LivingAreaRepository;

/**
 * Created by Game330 on 2016-04-29.
 */
public class LivingAreaTest extends AndroidTestCase{
    private static final String TAG="SETTINGS TEST";
    private Long id;
    // private Context getContext;

    public void testCreateReadUpdateDelete() throws Exception {
        LivingAreaRepository repo = new LivingAreaRepositoryImpl(this.getContext());
        // CREATE

        LivingArea createEntity = new LivingArea.Builder()
                .livingAreaId(Long.parseLong("234324"))
                .livingAreaName("Kraal")
                .build();
        LivingArea insertedEntity = repo.save(createEntity);
        id=insertedEntity.getLivingAreaId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<LivingArea> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        LivingArea entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        LivingArea updateEntity = new LivingArea.Builder()
                .copy(entity)
                .livingAreaId(Long.parseLong("234324"))
                .build();
        repo.update(updateEntity);
        LivingArea newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","234324",newEntity.getLivingAreaId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        LivingArea deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
