package www.cput.za.animalpound.animalRepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import www.cput.za.animalpound.domain.AnimalRecord;
import www.cput.za.animalpound.repository.animal.AnimalRecordRepository;
import www.cput.za.animalpound.repository.animal.Impl.AnimalRecordRepoImpl;

/**
 * Created by Game330 on 2016-04-29.
 */
public class AnimalRecordTest extends AndroidTestCase{
    private static final String TAG="SETTINGS TEST";
    private Long id;
    // private Context getContext;

    public void testCreateReadUpdateDelete() throws Exception {
        AnimalRecordRepository repo = new AnimalRecordRepoImpl(this.getContext());
        // CREATE

        AnimalRecord createEntity = new AnimalRecord.Builder()
                .id(Long.parseLong("234324"))
                .arrivalDate("12/04/2015")
                .leavingDate("Dog")
                .build();
        AnimalRecord insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<AnimalRecord> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        AnimalRecord entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        AnimalRecord updateEntity = new AnimalRecord.Builder()
                .copy(entity)
                .id(Long.parseLong("234324"))
                .build();
        repo.update(updateEntity);
        AnimalRecord newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","234324",newEntity.getId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        AnimalRecord deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
