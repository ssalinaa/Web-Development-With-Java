import React from 'react';
import { Link } from 'react-router-dom'; 
import styles from './CreateAccount.module.css'; 

const CreateAccount = () => {
  return (
    <div className={styles.createAccount}>
      <div className={styles.createAccountTitle}>
        Please, choose <br /> what kind of profile <br /> you want to create:
      </div>
      <div className={styles.createAccountContainer}>
        <Link to="/donee">
          <button
            id="donee"
            className={styles.doneeButton}
          >
            Donee
          </button>
        </Link>
        <Link to="/contributor">
          <button
            id="contributor"
            className={styles.contributorButton}
          >
            Contributor
          </button>
        </Link>
      </div>
    </div>
  );
};

export default CreateAccount;