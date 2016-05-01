package www.cput.za.animalpound.customerRepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import www.cput.za.animalpound.conf.AppUtil;
import www.cput.za.animalpound.domain.Adoption;
import www.cput.za.animalpound.repository.customer.AdoptionRepository;
import www.cput.za.animalpound.repository.customer.Impl.AdoptionRepositoryImpl;

/**
 * Created by Game330 on 2016-04-29.
 */
public class AdoptionTest extends AndroidTestCase {
    private static final String TAG="DONATION";
    private Long id;
    // private Context getContext;

    public void testCreateReadUpdateDelete() throws Exception {
        AdoptionRepository repo = new AdoptionRepositoryImpl(this.getContext());
        // CREATE

        Adoption createEntity = new Adoption.Builder()
                .adoptionId(Long.parseLong("324324"))
                .comment("Customer adopted a dog")
                .adoptionDate(AppUtil.getDate("24/06/2005"))
                .build();
       Adoption insertedEntity = repo.save(createEntity);
        id=insertedEntity.getAdoptionId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Adoption> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Adoption entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Adoption updateEntity = new Adoption.Builder()
                .copy(entity)
                .adoptionId(Long.parseLong("324324"))
                .build();
        repo.update(updateEntity);
        Adoption newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","234324",newEntity.getAdoptionId());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Adoption deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
