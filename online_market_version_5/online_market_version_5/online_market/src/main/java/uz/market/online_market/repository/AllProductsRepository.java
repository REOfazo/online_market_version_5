package uz.market.online_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.market.online_market.entity.AllProducts;

@Repository
public interface AllProductsRepository extends JpaRepository<AllProducts, Long> {
/*
    *//*-------------------------!!!! Buning barchasi maxsus so'rovlar bilan yaratildi. !!!! ----------------------------------*//*

    // Bu so'rov bazadagi "table"dan "name" qatorini oladi
    @Query(value = "select e.name from e", nativeQuery = true)
    public String getProductName(String name);

    // Bazadagi ko'rastilgan qatorning "id"sini yangilaydi
    @Query(value = "update set e.id=id from e", nativeQuery = true)
    void setId(int id);

    // Bazaga ma'lumotlarni saqlash
    @Query(value = "insert into e(id, name, color, price) from e values(e.id, e.name, e.color, e.price)", nativeQuery = true)
    public void setData(long id, String name, String color, double price);

    // Ko'rsatilgan "id" qiymati bo'yicha bazadagi qatorni o'chiradi
    @Query(value = "delete table * from e where id=e.id", nativeQuery = true)
    public void deleteById();*/
}
