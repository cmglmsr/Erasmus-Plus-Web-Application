function NavigationBar() {
  return (
    <header className="">
      <div className="">React Meetups</div>
      <nav>
        <ul>
          <li>
            <Link to="/">All Meetups</Link>
          </li>
          <li>
            <Link to="/">Add New Meetups</Link>
          </li>
          <li>
            <Link to="/">My Favorites</Link>
          </li>
        </ul>
      </nav>
          
    </header>
  );
}
export default NavigationBar;
