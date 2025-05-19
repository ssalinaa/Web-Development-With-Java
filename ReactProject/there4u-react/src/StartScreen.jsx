import React from 'react';
import { Link } from 'react-router-dom';
import styles from './StartScreen.module.css';

const StartScreen = () => {
  return (
    <div className={styles.startScreen}>
      <div className={styles.startScreenTitle}>THERE4U</div>
      <div className={styles.startScreenSubtitle}>DONATE FOOD</div>
      <div className={styles.quote}>
        “As we work to create<br /> light for others,<br /> we naturally<br /> light our own way”
      </div>
      <div className={styles.author}>Mary Anne Radmacher</div>

      <div className="images">
        <div className={styles.peopleImage1}></div>
        <div className={styles.peopleImage2}></div>
        <div className={styles.peopleImage3}></div>
        <div className={styles.foodImage4}></div>
      </div>

      <Link to="/login">
        <button className={styles.loginButton}>Log In</button>
      </Link>
      <Link to="/create-account">
        <button className={styles.createAccountButton}>Create Account</button>
      </Link>
      <Link to="/about-us">
        <button className={styles.aboutUsButton}>About Us</button>
      </Link>
    </div>
  );
};

export default StartScreen;