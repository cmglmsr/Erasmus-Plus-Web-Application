import { Outlet } from 'react-router-dom';
import {CourseWishlistProvider} from "./CourseWishlistContext"

const CourseWishlistContextLayout = () => {
  return (
    <CourseWishlistProvider>
      <Outlet />
    </CourseWishlistProvider>
  );
};

export default CourseWishlistContextLayout;