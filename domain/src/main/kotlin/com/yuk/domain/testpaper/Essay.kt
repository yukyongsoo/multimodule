package com.yuk.domain.testpaper

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("3")
class Essay : Problem(Test())
