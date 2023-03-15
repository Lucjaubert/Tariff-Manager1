package dev.wcs.nad.tariffmanager.address;

import dev.wcs.nad.tariffmanager.persistence.entity.Address;
import dev.wcs.nad.tariffmanager.persistence.jdbc.AddressLegacyDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class AddressJdbcTest {

    @Autowired
    private AddressLegacyDao addressLegacyDao;

    @Test
    public void shouldLoadAddressWithId2() {
        Optional<Address> firstAddress = addressLegacyDao.getByIdJava7Syntax(1);
        assertThat(firstAddress.isEmpty()).isFalse();
        assertThat(firstAddress.get().getId().toString().equals("1")).isTrue();
    }

    @Test
    public void shouldLoadAddressWithId7() {
        Optional<Address> address = addressLegacyDao.getByIdJava7Syntax(7);
        assertThat(address.isEmpty()).isFalse();
        assertThat(address.get().getId().toString().equals("7")).isTrue();
    }

    @Test
    public void shouldReturnEmptyIfAddressNotFound() {
        Optional<Address> address = addressLegacyDao.getByIdJava7Syntax(49);
        assertThat(address.isEmpty()).isTrue();
}


}
