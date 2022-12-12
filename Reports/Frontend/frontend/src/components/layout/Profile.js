import ProfileImage from './profile.jpg'
import classes from './Profile.module.css';
function Profile() {
  return (
    <div class="container">
      <div className="text-center">
        <img src={ProfileImage} class="rounded float-left" alt="..."></img>
        <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row"></th>

    </tr>
    <tr>
      <th scope="row"></th>
    </tr>
    <tr>
      <th scope="row"></th>
    </tr>
  </tbody>
</table>

      </div>
    </div>
  );
}
export default Profile;
