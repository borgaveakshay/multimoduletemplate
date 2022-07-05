package com.example.base

/**
 * [BaseUseCase] Represents the most basic use case for execution.
 */
abstract class BaseUseCase<IN, OUT> {
    abstract suspend fun execute(input: IN? = null): Resource<OUT>
    suspend operator fun invoke(input: IN?) = execute(input)
}