import ProfileSummary from "../components/Profile/ProfileSummary";

const DUMMY_PROFILE = 
  {
    role: "Student",
    image: "https://media-exp1.licdn.com/dms/image/D4D03AQEdRKW_KFlPHQ/profile-displayphoto-shrink_800_800/0/1665401571688?e=1675900800&v=beta&t=gv1Z-1e1Qwaglyupyd0o10c5YeCiO95fqjnqUtoc6fI",
    name: "Elifsena",
    surname: "Oz",
    department: "CS"
  }

function Homepage() {
  return (
    <section>
      <div className="row">
        <div className="col-3">
        <ProfileSummary profile={DUMMY_PROFILE} />
        </div>
        <div className="col-9">
        <ProfileSummary profile={DUMMY_PROFILE} />
        </div>
      </div>

    </section>
  );
}

export default Homepage;
