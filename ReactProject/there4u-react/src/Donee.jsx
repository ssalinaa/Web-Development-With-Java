import React, { useState } from 'react';
import styles from './Donee.module.css'; 

const Donee = () => {
  const [formDataRegular, setFormDataRegular] = useState({
    name: '',
    username: '',
    address: '',
    phone: '',
    email: '',
    password: '',
    ucn: ''
  });

  const [formDataNgo, setFormDataNgo] = useState({
    name: '',
    username: '',
    address: '',
    phone: '',
    email: '',
    password: '',
    description: ''
  });

  const handleRegularChange = (e) => {
    const { name, value } = e.target;
    setFormDataRegular({
      ...formDataRegular,
      [name]: value
    });
  };

  const handleNgoChange = (e) => {
    const { name, value } = e.target;
    setFormDataNgo({
      ...formDataNgo,
      [name]: value
    });
  };

  const handleRegularSubmit = (e) => {
    e.preventDefault();
    console.log('Regular User Data:', formDataRegular);
  };

  const handleNgoSubmit = (e) => {
    e.preventDefault();
    console.log('NGO User Data:', formDataNgo);
  };

  return (
    <div className={styles.container}>
      <div className={styles.registerBoxRegular}>
        <h1>Create Account<br />Regular User</h1>
        <form onSubmit={handleRegularSubmit}>
          <input
            type="text"
            placeholder="Name"
            required
            name="name"
            value={formDataRegular.name}
            onChange={handleRegularChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Username"
            required
            name="username"
            value={formDataRegular.username}
            onChange={handleRegularChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Address"
            required
            name="address"
            value={formDataRegular.address}
            onChange={handleRegularChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Phone"
            required
            name="phone"
            value={formDataRegular.phone}
            onChange={handleRegularChange}
            className={styles.input}
          />
          <input
            type="email"
            placeholder="Email"
            required
            name="email"
            value={formDataRegular.email}
            onChange={handleRegularChange}
            className={styles.input}
          />
          <input
            type="password"
            placeholder="Password"
            required
            name="password"
            value={formDataRegular.password}
            onChange={handleRegularChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Ucn"
            required
            name="ucn"
            value={formDataRegular.ucn}
            onChange={handleRegularChange}
            className={styles.input}
          />
          <button type="submit" className={styles.button}>Register</button>
        </form>
      </div>

      <div className={styles.registerBoxNGO}>
        <h1>Create Account<br />NGO User</h1>
        <form onSubmit={handleNgoSubmit}>
          <input
            type="text"
            placeholder="Name"
            required
            name="name"
            value={formDataNgo.name}
            onChange={handleNgoChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Username"
            required
            name="username"
            value={formDataNgo.username}
            onChange={handleNgoChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Address"
            required
            name="address"
            value={formDataNgo.address}
            onChange={handleNgoChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Phone"
            required
            name="phone"
            value={formDataNgo.phone}
            onChange={handleNgoChange}
            className={styles.input}
          />
          <input
            type="email"
            placeholder="Email"
            required
            name="email"
            value={formDataNgo.email}
            onChange={handleNgoChange}
            className={styles.input}
          />
          <input
            type="password"
            placeholder="Password"
            required
            name="password"
            value={formDataNgo.password}
            onChange={handleNgoChange}
            className={styles.input}
          />
          <input
            type="text"
            placeholder="Description"
            required
            name="description"
            value={formDataNgo.description}
            onChange={handleNgoChange}
            className={styles.input}
          />
          <button type="submit" className={styles.button}>Register</button>
        </form>
      </div>
        <div className={styles.Image1}></div>
        <div className={styles.Image2}></div>
      </div>
  );
};

export default Donee;