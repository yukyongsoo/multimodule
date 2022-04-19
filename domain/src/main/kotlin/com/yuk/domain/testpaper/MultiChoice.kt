package com.yuk.domain.testpaper

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("1")
class MultiChoice : Problem(Test())
