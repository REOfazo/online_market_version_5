package uz.market.online_market.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "all_products_sold")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AllProductsSold implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private AllUsers allUsers;

    @OneToOne
    private AllProducts allProducts;

    @Column(name = "sotilgan_narxi", nullable = false)
    private double sotilganNarxi;

    @Column(name = "sotilish_usuli", nullable = false)
    private String sotilishUsuli;

    @Column(name = "create_product_sold_date")
    @CreationTimestamp
    private LocalDateTime createProductSoldDate;

    @Column(name = "update_product_sold_date")
    @UpdateTimestamp
    private LocalDateTime updateProductSoldDate;
}
