package com.example.trackly.data

import androidx.room.*
import com.example.trackly.model.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Query("SELECT * FROM budgets ORDER BY year DESC, month DESC")
    fun getAllBudgets(): Flow<List<Budget>>

    @Query("SELECT * FROM budgets WHERE id = :id")
    suspend fun getBudgetById(id: Int): Budget?

    @Query("SELECT * FROM budgets WHERE year = :year AND month = :month")
    suspend fun getBudgetForMonth(year: Int, month: Int): Budget?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudget(budget: Budget)

    @Update
    suspend fun updateBudget(budget: Budget)

    @Delete
    suspend fun deleteBudget(budget: Budget)

    @Query("SELECT * FROM budgets WHERE year = :year")
    fun getBudgetsForYear(year: Int): Flow<List<Budget>>
} 