package com.expensetracker.config;

import com.expensetracker.entity.Category;
import com.expensetracker.entity.TransactionType;
import com.expensetracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            Arrays.asList(
                // --- EXPENSES ---
                Category.builder().name("Food").type(TransactionType.EXPENSE).icon("🍔").isDefault(true).build(),
                Category.builder().name("Transport").type(TransactionType.EXPENSE).icon("🚗").isDefault(true).build(),
                Category.builder().name("Shopping").type(TransactionType.EXPENSE).icon("🛍️").isDefault(true).build(),
                Category.builder().name("Entertainment").type(TransactionType.EXPENSE).icon("🎬").isDefault(true).build(),
                
                // Housing & Utilities
                Category.builder().name("Rent/Mortgage").type(TransactionType.EXPENSE).icon("🏠").isDefault(true).build(),
                Category.builder().name("Utilities").type(TransactionType.EXPENSE).icon("💡").isDefault(true).build(),
                Category.builder().name("Subscriptions").type(TransactionType.EXPENSE).icon("📱").isDefault(true).build(),
                
                // Health & Wellness
                Category.builder().name("Medical & Health").type(TransactionType.EXPENSE).icon("🏥").isDefault(true).build(),
                Category.builder().name("Fitness/Gym").type(TransactionType.EXPENSE).icon("🏋️").isDefault(true).build(),
                
                // Education & Self-Growth
                Category.builder().name("Education").type(TransactionType.EXPENSE).icon("📚").isDefault(true).build(),
                
                // Financial Outflows
                Category.builder().name("Insurance").type(TransactionType.EXPENSE).icon("🛡️").isDefault(true).build(),
                Category.builder().name("Investments").type(TransactionType.EXPENSE).icon("📈").isDefault(true).build(),
                Category.builder().name("Gifts & Charity").type(TransactionType.EXPENSE).icon("🎁").isDefault(true).build(),
                
                // Miscellaneous
                Category.builder().name("Others").type(TransactionType.EXPENSE).icon("📝").isDefault(true).build(),

                // --- INCOME ---
                Category.builder().name("Salary").type(TransactionType.INCOME).icon("💰").isDefault(true).build(),
                Category.builder().name("Freelance/Side Hustle").type(TransactionType.INCOME).icon("💻").isDefault(true).build(),
                Category.builder().name("Investments Return").type(TransactionType.INCOME).icon("📊").isDefault(true).build(),
                Category.builder().name("Gifts/Awards").type(TransactionType.INCOME).icon("✉️").isDefault(true).build()
            ).forEach(categoryRepository::save);

        }
    }
}
