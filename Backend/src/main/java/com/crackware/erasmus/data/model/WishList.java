package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class WishList extends List{

    @OneToMany
    private Set<WishlistCourse> wishlistCourses;

    private Status status;
}
