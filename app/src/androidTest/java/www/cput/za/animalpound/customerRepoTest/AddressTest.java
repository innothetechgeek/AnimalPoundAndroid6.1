package www.cput.za.animalpound.customerRepoTest;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import www.cput.za.animalpound.domain.Address;
import www.cput.za.animalpound.repository.customer.AddressRepository;
import www.cput.za.animalpound.repository.customer.Impl.AddressRepositoryImpl;

/**
 * Created by Game330 on 2016-04-29.
 */
public class AddressTest extends AndroidTestCase {
    private static final String TAG="ADDRESS TEST";
    private Long id;
    // private Context getContext;

    public void testCreateReadUpdateDelete() throws Exception {
        AddressRepository repo = new AddressRepositoryImpl(this.getContext());
        // CREATE

        Address createEntity = new Address.Builder()
                .room("287")
                .street("Watergang")
                .surbub("Stellenbosch")
                .zipCode("7600")
                .build();
       /* Address insertedEntity = repo.save(createEntity);
        id=insertedEntity.getRoom();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);*/

        //READ ALL
        Set<Address> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        Address entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Address updateEntity = new Address.Builder()
                .copy(entity)
                .room(("287"))
                .build();
        repo.update(updateEntity);
        Address newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","234324",newEntity.getRoom());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Address deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
