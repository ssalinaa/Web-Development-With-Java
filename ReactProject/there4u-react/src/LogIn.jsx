import React, { useState } from 'react';
import styles from './LogIn.module.css'; 

const LogIn = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Email:', email);
    console.log('Password:', password);
  };

  return (
    <div className={styles.wrapper}>
    <div className={styles.loginBox}>
      <h1>Log In</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          placeholder="Email or username"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
          className={styles.inputField}
          aria-label="Email or username"
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
          className={styles.inputField}
          aria-label="Password"
        />
        <button type="submit" className={styles.submitButton}>Log In</button>
      </form>
      <div className={styles.image1}></div>
      <div className={styles.image2}></div>
    </div>
    </div>
  );
};

export default LogIn;