package com.yuk.domain.book

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("2")
class EBook : Book()
