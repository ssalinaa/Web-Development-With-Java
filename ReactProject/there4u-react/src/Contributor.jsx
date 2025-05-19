import React, { useState } from 'react';
import styles from './Contributor.module.css'; 

const Contributor = () => {
  const [formData, setFormData] = useState({
    name: '',
    username: '',
    address: '',
    phone: '',
    email: '',
    password: '',
    userType: '',
    description: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
  };

  return (
    <div className={styles.registerBoxContributor}>
      <h1>Create Account<br />Contributor</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Name"
          required
          name="name"
          value={formData.name}
          onChange={handleChange}
          className={styles.input}
        />
        <input
          type="text"
          placeholder="Username"
          required
          name="username"
          value={formData.username}
          onChange={handleChange}
          className={styles.input}
        />
        <input
          type="text"
          placeholder="Address"
          required
          name="address"
          value={formData.address}
          onChange={handleChange}
          className={styles.input}
        />
        <input
          type="text"
          placeholder="Phone"
          required
          name="phone"
          value={formData.phone}
          onChange={handleChange}
          className={styles.input}
        />
        <input
          type="text"
          placeholder="Email"
          required
          name="email"
          value={formData.email}
          onChange={handleChange}
          className={styles.input}
        />
        <input
          type="password"
          placeholder="Password"
          required
          name="password"
          value={formData.password}
          onChange={handleChange}
          className={styles.input}
        />
        <select
          required
          name="userType"
          value={formData.userType}
          onChange={handleChange}
          className={styles.select}
        >
          <option value="" disabled>Select Type Of User</option>
          <option value="CANTEEN">CANTEEN</option>
          <option value="RESTAURANT">RESTAURANT</option>
          <option value="GROCERY_STORE">GROCERY_STORE</option>
        </select>
        <input
          type="text"
          placeholder="Description"
          required
          name="description"
          value={formData.description}
          onChange={handleChange}
          className={styles.input}
        />
        <button type="submit" className={styles.button}>Register</button>
      </form>
      <div className={styles.image1}></div>
      <div className={styles.image2}></div>
    </div>
  );
};

export default Contributor;