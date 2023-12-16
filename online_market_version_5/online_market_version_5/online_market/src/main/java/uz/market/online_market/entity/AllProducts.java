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
@Table(name = "all_products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AllProducts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_color", nullable = false)
    private String productColor;

    @Column(name = "warranty_year", nullable = false)
    private byte warrantyYear;

    @Column(name = "mahsulot_miqdori", nullable = false)
    private int mahsulotMiqdori;

    @Column(name = "buy_price")
    private double buyPrice;

    @Column(name = "create_product_date")
    @CreationTimestamp
    private LocalDateTime createProductDate;

    @Column(name = "update_product_date")
    @UpdateTimestamp
    private LocalDateTime updateProductDate;
}
