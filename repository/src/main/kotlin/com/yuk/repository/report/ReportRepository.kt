package com.yuk.repository.report

import com.yuk.domain.report.Report
import com.yuk.domain.report.Reports
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class ReportRepository(
    private val reportJpaRepository: ReportJpaRepository
) : Reports

interface ReportJpaRepository : JpaRepository<Report, Long>
