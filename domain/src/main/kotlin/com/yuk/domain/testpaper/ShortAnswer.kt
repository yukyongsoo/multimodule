package com.yuk.domain.testpaper

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("2")
class ShortAnswer : Problem(Test())
