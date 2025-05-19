import React from 'react';
import styles from './AboutUs.module.css'; 

const AboutUs = () => {
  return (
    <div>
      <div className={styles.AboutUsScreen}> </div>
      <div className={styles.title}>WHO ARE WE?</div>
      <div className={styles.container1}>
        <p className={styles.p1}>
          THERE4U is a platform designed to connect those in need with those willing to help.
          We do not distribute food directly — instead, we provide a safe and accessible environment
          where donors (contributors) and recipients (donees) can find each other, communicate,
          and organize donations in a simple and trustworthy way.
        </p>
      </div>
      <div className={styles.container2}>
        <p className={styles.p2}>
          Our role is to facilitate connection, ensure transparency and security,
          and inspire more people to take part in acts of kindness. We believe that
          everyone can be part of the change, even with the smallest gesture — 
          all it takes is the right support.
        </p>
      </div>
      <div className={styles.image1}></div>
      <div className={styles.image2}></div>
      <div className={styles.image3}></div>
      <div className={styles.image4}></div>
    </div>
  );
};

export default AboutUs;