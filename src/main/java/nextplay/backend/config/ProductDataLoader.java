package nextplay.backend.config;  
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nextplay.backend.models.Product;
import nextplay.backend.repositories.ProductRepository;

@Component
public class ProductDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // Si ya hay productos, no sembrar de nuevo
        if (productRepository.count() > 0) {
            return;
        }

        Product p1 = new Product();
        p1.setName("Recarga Genshin Impact Genesis Crystals");
        p1.setDescription("1980 Protogemas + 260 Bonus");
        p1.setPrice((long) 29990);
        p1.setImage("/img/genshin.jpg");

        Product p2 = new Product();
        p2.setName("ELDEN RING Shadow of the Erdtree Premium Bundle (DLC)");
        p2.setDescription("Se requiere el juego base Elden Ring para poder jugar");
        p2.setPrice((long) 49990);
        p2.setImage("/img/elden_ring.jpg");

        Product p3 = new Product();
        p3.setName("Overwatch® 2: Pink Mercy Skin (DLC)");
        p3.setDescription("Cosmético para el personaje Mercy");
        p3.setPrice((long) 9990);
        p3.setImage("/img/mercy.jpg");

        Product p4 = new Product();
        p4.setName("METAL GEAR SOLID Δ: SNAKE EATER");
        p4.setDescription("Juego base");
        p4.setPrice((long) 32990);
        p4.setImage("/img/metal_gear.jpg");

        Product p5 = new Product();
        p5.setName("Persona 5 Royal");
        p5.setDescription("Juego Base + Contenido Adicional");
        p5.setPrice((long) 19990);
        p5.setImage("/img/persona_5.jpg");

        Product p6 = new Product();
        p6.setName("Minecraft");
        p6.setDescription("Edition Bedrock + Java");
        p6.setPrice((long) 15990);
        p6.setImage("/img/minecraft.jpg");

        productRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6));
    }
}
